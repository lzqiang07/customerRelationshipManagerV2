package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.po.Customer;
import com.shsxt.crm.query.CustomerQuery;
import com.shsxt.crm.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by lp on 2018/5/4.
 */
@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController {

    @Resource
    private CustomerService customerService;


    @RequestMapping("index")
    public String index() {
        return "customer";
    }

    @RequestMapping("queryCustomersByParams")
    @ResponseBody
    public Map<String, Object> queryCustomersByParams(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer rows,
            CustomerQuery customerQuery) {
        customerQuery.setPageSize(rows);
        customerQuery.setPageNum(page);
        return customerService.queryForPage(customerQuery);

    }

    @RequestMapping("addOrUpdateCustomer")
    @ResponseBody
    public ResultInfo addOrUpdateCustomer(Customer customer) {
        customerService.addOrUpdateCustomer(customer);
        return success(CrmConstant.OPS_SUCCESS_MSG);
    }

    @RequestMapping("deleteCustomer")
    @ResponseBody
    public ResultInfo deleteCustomers(Integer[] ids) {
        customerService.deleteBatch(ids);
        return success(CrmConstant.OPS_SUCCESS_MSG);
    }

    @RequestMapping("addLossCustomers")
    @ResponseBody
    public ResultInfo addLossCustomers(){
        customerService.addLossCustomers();
        return success(CrmConstant.OPS_SUCCESS_MSG);
    }


}
