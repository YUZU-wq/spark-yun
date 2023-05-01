package com.isxcode.star.backend.module.tenant.user.controller;

import com.isxcode.star.api.constants.ModulePrefix;
import com.isxcode.star.api.constants.Roles;
import com.isxcode.star.api.constants.SecurityConstants;
import com.isxcode.star.api.pojos.tenant.user.req.TurAddTenantUserReq;
import com.isxcode.star.api.pojos.tenant.user.req.TurQueryTenantUserReq;
import com.isxcode.star.api.pojos.tenant.user.res.TurQueryTenantUserRes;
import com.isxcode.star.api.response.SuccessResponse;
import com.isxcode.star.backend.module.tenant.user.service.TenantUserBizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "租户用户模块")
@RestController
@RequestMapping(ModulePrefix.TENANT_USER)
@RequiredArgsConstructor
public class TenantUserController {

  private final TenantUserBizService tenantUserBizService;

  @Secured({Roles.SYS_ADMIN, Roles.TENANT_ADMIN})
  @Operation(summary = "添加用户接口")
  @PostMapping("/addTenantUser")
  @SuccessResponse("添加成功")
  @Parameter(name = "Tenant", description = "租户id", required = true, in = ParameterIn.HEADER, schema = @Schema(type = "string"))
  public void addTenantUser(@Valid @RequestBody TurAddTenantUserReq turAddTenantUserReq) {

    tenantUserBizService.addTenantUser(turAddTenantUserReq);
  }

  @Secured({Roles.SYS_ADMIN, Roles.TENANT_ADMIN})
  @Operation(summary = "查询租户用户列表接口")
  @PostMapping("/queryTenantUser")
  @SuccessResponse("查询成功")
  @Parameter(name = SecurityConstants.HEADER_TENANT_ID, description = "租户id", required = true, in = ParameterIn.HEADER, schema = @Schema(type = "string"))
  public Page<TurQueryTenantUserRes> queryTenantUser(@Valid @RequestBody TurQueryTenantUserReq turQueryTenantUserReq) {

    return tenantUserBizService.queryTenantUser(turQueryTenantUserReq);
  }

  @Secured({Roles.SYS_ADMIN, Roles.TENANT_ADMIN})
  @Operation(summary = "移除用户接口")
  @PostMapping("/removeTenantUser")
  @SuccessResponse("移除成功")
  @Parameter(name = "Tenant", description = "租户id", required = true, in = ParameterIn.HEADER, schema = @Schema(type = "string"))
  public void removeTenantUser(@Schema(description = "用户唯一id", example = "sy_ff3c1b52f8b34c45ab2cf24b6bccd480") @RequestParam String userId) {

    tenantUserBizService.removeTenantUser(userId);
  }

  @Secured({Roles.SYS_ADMIN, Roles.TENANT_ADMIN})
  @Operation(summary = "设置为租户管理员接口")
  @PostMapping("/setTenantAdmin")
  @SuccessResponse("设置成功")
  @Parameter(name = "Tenant", description = "租户id", required = true, in = ParameterIn.HEADER, schema = @Schema(type = "string"))
  public void setTenantAdmin(@Schema(description = "用户唯一id", example = "sy_ff3c1b52f8b34c45ab2cf24b6bccd480") @RequestParam String userId) {

    tenantUserBizService.setTenantAdmin(userId);
  }

  @Secured({Roles.SYS_ADMIN, Roles.TENANT_ADMIN})
  @Operation(summary = "取消设置为租户管理员接口")
  @PostMapping("/removeTenantAdmin")
  @SuccessResponse("设置成功")
  @Parameter(name = "Tenant", description = "租户id", required = true, in = ParameterIn.HEADER, schema = @Schema(type = "string"))
  public void removeTenantAdmin(@Schema(description = "用户唯一id", example = "sy_ff3c1b52f8b34c45ab2cf24b6bccd480") @RequestParam String userId) {

    tenantUserBizService.removeTenantAdmin(userId);
  }
}

