/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.configuration;
/**
 *
 * @author SAP Training
 *//*
@Configuration
public class WebConfigurer implements ServletContextInitializer, EmbeddedServletContainerCustomizer {
    
    private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

    private final Environment env;
    private static final String STATIC_ASSETS_FOLDER_PARAM = "static-assets-folder";
    private final String staticAssetsFolderPath;

    public WebConfigurer(Environment env, @Value("${" + STATIC_ASSETS_FOLDER_PARAM + ":}") String staticAssetsFolderPath) {
        this.env = env;
        this.staticAssetsFolderPath = staticAssetsFolderPath;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        if (env.getActiveProfiles().length > 0) {
            log.info("Web application configuration, profiles: {}", (Object[]) env.getActiveProfiles());
        }
        log.info(STATIC_ASSETS_FOLDER_PARAM + ": '{}'", staticAssetsFolderPath);
    }

    private void customizeDocumentRoot(ConfigurableEmbeddedServletContainer container) {
        if (!StringUtils.isEmpty(staticAssetsFolderPath)) {
            File docRoot;
            if (staticAssetsFolderPath.startsWith(File.separator)) {
                docRoot = new File(staticAssetsFolderPath);
            } else {
                final String workPath = Paths.get(".").toUri().normalize().getPath();
                docRoot = new File(workPath + staticAssetsFolderPath);
            }
            if (docRoot.exists() && docRoot.isDirectory()) {
                log.info("Custom location is used for static assets, document root folder: {}",
                        docRoot.getAbsolutePath());
                container.setDocumentRoot(docRoot);
            } else {
                log.warn("Custom document root folder {} doesn't exist, custom location for static assets was not used.",
                        docRoot.getAbsolutePath());
            }
        }
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        customizeDocumentRoot(container);
    }
    
}
*/