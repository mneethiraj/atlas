/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.atlas.examples;

import org.apache.atlas.AtlasServiceException;
import org.apache.atlas.model.instance.AtlasClassification;
import org.apache.atlas.model.instance.AtlasClassification.AtlasClassifications;
import org.apache.atlas.model.instance.AtlasEntity;
import org.apache.atlas.model.instance.AtlasEntity.AtlasEntitiesWithExtInfo;
import org.apache.atlas.model.instance.AtlasEntityHeader;
import org.apache.atlas.model.lineage.AtlasLineageInfo;
import org.apache.atlas.model.lineage.AtlasLineageInfo.LineageDirection;
import org.apache.atlas.model.lineage.AtlasLineageInfo.LineageRelation;
import org.apache.atlas.web.integration.BaseResourceIT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.apache.atlas.AtlasClient.REFERENCEABLE_ATTRIBUTE_NAME;
import static org.apache.atlas.examples.QuickStartV2.CLUSTER_SUFFIX;
import static org.apache.atlas.examples.QuickStartV2.CUSTOMER_DIM_TABLE;
import static org.apache.atlas.examples.QuickStartV2.LOAD_PROCESS_TYPE;
import static org.apache.atlas.examples.QuickStartV2.LOAD_SALES_DAILY_PROCESS;
import static org.apache.atlas.examples.QuickStartV2.LOAD_SALES_MONTHLY_PROCESS;
import static org.apache.atlas.examples.QuickStartV2.LOG_FACT_DAILY_MV_TABLE;
import static org.apache.atlas.examples.QuickStartV2.LOG_FACT_MONTHLY_MV_TABLE;
import static org.apache.atlas.examples.QuickStartV2.PRODUCT_DIM_TABLE;
import static org.apache.atlas.examples.QuickStartV2.PRODUCT_DIM_VIEW;
import static org.apache.atlas.examples.QuickStartV2.SALES_DB;
import static org.apache.atlas.examples.QuickStartV2.SALES_FACT_DAILY_MV_TABLE;
import static org.apache.atlas.examples.QuickStartV2.SALES_FACT_MONTHLY_MV_TABLE;
import static org.apache.atlas.examples.QuickStartV2.SALES_FACT_TABLE;
import static org.apache.atlas.examples.QuickStartV2.TIME_DIM_TABLE;
import static org.apache.atlas.examples.QuickStartV2.VIEW_TYPE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class QuickStartV2IT extends BaseResourceIT {
    @BeforeClass
    public void runQuickStart() throws Exception {
        super.setUp();

        QuickStartV2.runQuickstart(new String[] {}, new String[] {"admin", "admin"});
    }

    @Test
    public void testDBIsAdded() throws Exception {
        AtlasEntity         db           = getDB(SALES_DB);
        Map<String, Object> dbAttributes = db.getAttributes();

        assertEquals(dbAttributes.get("name"), SALES_DB);
        assertEquals(dbAttributes.get("description"), "sales database");
    }

    @Test
    public void testTablesAreAdded() throws AtlasServiceException {
        AtlasEntity table = getTable(SALES_FACT_TABLE);

        verifySimpleTableAttributes(table);

        verifyDBIsLinkedToTable(table);

        verifyColumnsAreAddedToTable(table);

        verifyTrait(table);
    }

    @Test
    public void testTablesAreAdded2() throws AtlasServiceException {
        List<String> tableNames = Arrays.asList(SALES_FACT_TABLE, PRODUCT_DIM_TABLE, CUSTOMER_DIM_TABLE,
                TIME_DIM_TABLE, SALES_FACT_DAILY_MV_TABLE, SALES_FACT_MONTHLY_MV_TABLE,
                LOG_FACT_DAILY_MV_TABLE, LOG_FACT_MONTHLY_MV_TABLE);

        AtlasEntitiesWithExtInfo entities = getTables(tableNames);

        assertNotNull(entities);
        assertNotNull(entities.getEntities());
        assertEquals(entities.getEntities().size(), tableNames.size());
    }

    @Test
    public void testProcessIsAdded() throws AtlasServiceException {
        Map<String, String> attributes         = Collections.singletonMap(REFERENCEABLE_ATTRIBUTE_NAME, LOAD_SALES_DAILY_PROCESS + CLUSTER_SUFFIX);
        AtlasEntity         loadProcess        = atlasClientV2.getEntityByAttribute(LOAD_PROCESS_TYPE, attributes).getEntity();
        Map<String, Object> loadProcessAttribs = loadProcess.getAttributes();

        assertEquals(loadProcessAttribs.get(NAME), LOAD_SALES_DAILY_PROCESS);
        assertEquals(loadProcessAttribs.get("description"), "hive query for daily summary");

        List<?> inputs  = (List<?>) loadProcessAttribs.get("inputs");
        List<?> outputs = (List<?>) loadProcessAttribs.get("outputs");

        assertEquals(inputs.size(), 2);

        String salesFactTableId   = getTableId(SALES_FACT_TABLE);
        String timeDimTableId     = getTableId(TIME_DIM_TABLE);
        String salesFactDailyMVId = getTableId(SALES_FACT_DAILY_MV_TABLE);

        assertEquals(salesFactTableId, ((Map<?, ?>) inputs.get(0)).get("guid"));
        assertEquals(timeDimTableId, ((Map<?, ?>) inputs.get(1)).get("guid"));
        assertEquals(salesFactDailyMVId, ((Map<?, ?>) outputs.get(0)).get("guid"));
    }

    @Test
    public void testLineageIsMaintained() throws AtlasServiceException {
        String salesFactTableId      = getTableId(SALES_FACT_TABLE);
        String timeDimTableId        = getTableId(TIME_DIM_TABLE);
        String salesFactDailyMVId    = getTableId(SALES_FACT_DAILY_MV_TABLE);
        String salesFactMonthlyMvId  = getTableId(SALES_FACT_MONTHLY_MV_TABLE);
        String salesDailyProcessId   = getProcessId(LOAD_SALES_DAILY_PROCESS);
        String salesMonthlyProcessId = getProcessId(LOAD_SALES_MONTHLY_PROCESS);

        AtlasLineageInfo               inputLineage = atlasClientV2.getLineageInfo(salesFactDailyMVId, LineageDirection.BOTH, 0);
        List<LineageRelation>          relations    = new ArrayList<>(inputLineage.getRelations());
        Map<String, AtlasEntityHeader> entityMap    = inputLineage.getGuidEntityMap();

        assertEquals(relations.size(), 5);
        assertEquals(entityMap.size(), 6);

        assertTrue(entityMap.containsKey(salesFactTableId));
        assertTrue(entityMap.containsKey(timeDimTableId));
        assertTrue(entityMap.containsKey(salesFactDailyMVId));
        assertTrue(entityMap.containsKey(salesDailyProcessId));
        assertTrue(entityMap.containsKey(salesFactMonthlyMvId));
        assertTrue(entityMap.containsKey(salesMonthlyProcessId));
    }

    @Test
    public void testViewIsAdded() throws AtlasServiceException {
        Map<String, String> attributes                 = Collections.singletonMap(REFERENCEABLE_ATTRIBUTE_NAME, PRODUCT_DIM_VIEW + CLUSTER_SUFFIX);
        AtlasEntity         view                       = atlasClientV2.getEntityByAttribute(VIEW_TYPE, attributes).getEntity();
        Map<String, Object> viewAttributes             = view.getAttributes();
        Map<String, Object> viewRelationshipAttributes = view.getRelationshipAttributes();

        assertEquals(viewAttributes.get(NAME), PRODUCT_DIM_VIEW);

        String    productDimId   = getTable(PRODUCT_DIM_TABLE).getGuid();
        List<?>   inputTables    = (List<?>) viewRelationshipAttributes.get("inputTables");
        Map<?, ?> inputTablesMap = (Map<?, ?>) inputTables.get(0);

        assertEquals(productDimId, inputTablesMap.get("guid"));
    }

    private AtlasEntity getDB(String dbName) throws AtlasServiceException {
        Map<String, String> attributes = Collections.singletonMap(REFERENCEABLE_ATTRIBUTE_NAME, dbName + CLUSTER_SUFFIX);

        return atlasClientV2.getEntityByAttribute(QuickStartV2.DATABASE_TYPE, attributes).getEntity();
    }

    private AtlasEntity getTable(String tableName) throws AtlasServiceException {
        Map<String, String> attributes  = Collections.singletonMap(REFERENCEABLE_ATTRIBUTE_NAME, tableName + CLUSTER_SUFFIX);

        return atlasClientV2.getEntityByAttribute(QuickStartV2.TABLE_TYPE, attributes).getEntity();
    }

    private AtlasEntitiesWithExtInfo getTables(List<String> tableNames) throws AtlasServiceException {
        List<Map<String, String>> attributesList = new ArrayList<>();

        for (String tableName : tableNames) {
            attributesList.add(Collections.singletonMap(REFERENCEABLE_ATTRIBUTE_NAME, tableName + CLUSTER_SUFFIX));
        }

        return atlasClientV2.getEntitiesByAttribute(QuickStartV2.TABLE_TYPE, attributesList);
    }

    private AtlasEntity getProcess(String processName) throws AtlasServiceException {
        Map<String, String> attributes    = Collections.singletonMap(REFERENCEABLE_ATTRIBUTE_NAME, processName + CLUSTER_SUFFIX);

        return atlasClientV2.getEntityByAttribute(LOAD_PROCESS_TYPE, attributes).getEntity();
    }

    private void verifyTrait(AtlasEntity table) throws AtlasServiceException {
        AtlasClassifications      classfications = atlasClientV2.getClassifications(table.getGuid());
        List<AtlasClassification> traits         = classfications.getList();

        assertNotNull(traits.get(0).getTypeName());
    }

    private void verifyColumnsAreAddedToTable(AtlasEntity table) {
        Map<String, Object> tableAttributes = table.getRelationshipAttributes();
        List<Map<?, ?>>     columns         = (List<Map<?, ?>>) tableAttributes.get("columns");

        assertEquals(columns.size(), 4);

        for (Map<?, ?> colMap : columns) {
            String colGuid = (String) colMap.get("guid");

            assertNotNull(UUID.fromString(colGuid));
        }
    }

    private void verifyDBIsLinkedToTable(AtlasEntity table) throws AtlasServiceException {
        AtlasEntity         db              = getDB(SALES_DB);
        Map<String, Object> tableAttributes = table.getRelationshipAttributes();
        Map<?, ?>           dbFromTable     = (Map<?, ?>) tableAttributes.get("db");

        assertEquals(db.getGuid(), dbFromTable.get("guid"));
    }

    private void verifySimpleTableAttributes(AtlasEntity table) {
        Map<String, Object> tableAttributes = table.getAttributes();

        assertEquals(tableAttributes.get("name"), SALES_FACT_TABLE);
        assertEquals(tableAttributes.get("description"), "sales fact table");
    }

    private String getTableId(String tableName) throws AtlasServiceException {
        return getTable(tableName).getGuid();
    }

    private String getProcessId(String processName) throws AtlasServiceException {
        return getProcess(processName).getGuid();
    }
}
