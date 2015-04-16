package ganja.plugin.jtwig

import ganja.common.di.ContainerInterface
import ganja.common.plugin.PluginInterface
import ganja.component.di.loader.FileLoaderInterface
import ganja.component.di.loader.YmlFileLoader
import ganja.component.di.parser.DefinitionParser
import org.slf4j.LoggerFactory
import org.yaml.snakeyaml.Yaml

class JtwigPlugin implements PluginInterface {

    FileLoaderInterface fileLoader
    DefinitionParser parser

    @Override
    void registerServices(ContainerInterface container) {

        fileLoader = new YmlFileLoader(
                yaml: new Yaml(),
                prefix: getClass().getSimpleName(),
                logger: LoggerFactory.getLogger(YmlFileLoader)
        )

        parser = new DefinitionParser()

        parser.parse(fileLoader.load('/config/services.yml') as Map, container)
    }
}
