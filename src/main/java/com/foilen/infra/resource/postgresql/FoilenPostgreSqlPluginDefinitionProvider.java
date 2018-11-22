/*
    Foilen Infra Resource PostgreSQL
    https://github.com/foilen/foilen-infra-resource-postgresql
    Copyright (c) 2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.resource.postgresql;

import java.util.Arrays;

import com.foilen.infra.plugin.v1.core.context.CommonServicesContext;
import com.foilen.infra.plugin.v1.core.plugin.IPPluginDefinitionProvider;
import com.foilen.infra.plugin.v1.core.plugin.IPPluginDefinitionV1;

public class FoilenPostgreSqlPluginDefinitionProvider implements IPPluginDefinitionProvider {

    @Override
    public IPPluginDefinitionV1 getIPPluginDefinition() {
        IPPluginDefinitionV1 pluginDefinitionV1 = new IPPluginDefinitionV1("Foilen", "PostgreSql", "To manage PostgreSql databases", "1.0.0");

        pluginDefinitionV1.addCustomResource(PostgreSqlServer.class, PostgreSqlServer.RESOURCE_TYPE, //
                Arrays.asList(PostgreSqlServer.PROPERTY_NAME), //
                Arrays.asList( //
                        PostgreSqlServer.PROPERTY_NAME, //
                        PostgreSqlServer.PROPERTY_DESCRIPTION //
                ));

        // Resource editors
        pluginDefinitionV1.addTranslations("/com/foilen/infra/resource/postgresql/messages");
        pluginDefinitionV1.addResourceEditor(new PostgreSqlServerEditor(), PostgreSqlServerEditor.EDITOR_NAME);

        // Update events
        pluginDefinitionV1.addUpdateHandler(new PostgreSqlServerUpdateHandler());

        return pluginDefinitionV1;
    }

    @Override
    public void initialize(CommonServicesContext commonServicesContext) {
    }

}
