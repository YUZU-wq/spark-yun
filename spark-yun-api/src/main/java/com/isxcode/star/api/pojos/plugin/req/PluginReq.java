package com.isxcode.star.api.pojos.plugin.req;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PluginReq {

  private String sql;

  private Integer limit;

  private String applicationId;

  private Map<String, String> sparkConfig;

  private String args;
}
