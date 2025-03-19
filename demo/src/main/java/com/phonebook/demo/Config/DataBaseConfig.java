package com.phonebook.demo.Config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class DataBaseConfig {
    private String url;
    private String username;
    private String password;

    @Bean
    public DataBaseConfig loadDetails() {
        DataBaseConfig databaseConfig = new DataBaseConfig();
        databaseConfig.setUrl("jdbc:mysql://10.5.13.204:3306/KPro_0802");
        databaseConfig.setUsername("iolite");
        databaseConfig.setPassword("Io@Mhs27");
//        databaseConfig.setUrl(VaultUtils.instance.get(VaultUtils.CONFIG_SECTION_APP_CONFIG,"security.erp.admin.db.url").getValue());
//        databaseConfig.setUsername(VaultUtils.instance.get(VaultUtils.CONFIG_SECTION_APP_CONFIG,"security.erp.admin.db.username").getValue());
//        databaseConfig.setPassword(VaultUtils.instance.get(VaultUtils.CONFIG_SECTION_APP_CONFIG,"security.erp.admin.db.password").getValue());
        return databaseConfig;
    }
}
