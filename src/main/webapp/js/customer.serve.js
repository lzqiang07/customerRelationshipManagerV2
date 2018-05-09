
function fn() {
    // 弹窗提示
    // 清空表单
    $.messager.alert('来自crm',"添加成功");
    $('#fm').form('clear');
}

// 保存
function saveCustomerServe() {
    saveOrUpdateData('fm',ctx+'/customerServe/saveCustomerServe','',fn);
}

// 刷新
function searchByParams() {
    $('#dg').datagrid('load');
}

// 分配
function openCustomerServeAssignDialog() {
    openModifyDialog('dg','fm','dlg','服务分配')
}

// 处理
function openCustomerServeProceDialog() {
    openModifyDialog('dg','fm','dlg','服务处理')
}

// 反馈
function openCustomerServeFeedBackDialog() {
    openModifyDialog('dg','fm','dlg','服务反馈')
}
// 更新
function addCustomerServeAssign() {
    $("#fm").form("submit",{
        url:ctx+'/customerServe/updateCustomerServe',
        onSubmit:function(){
            return $("#fm").form("validate");
        },
        success:function (data) {
            /**
             * data 为原始的json 字符串
             *   需要转换为js 对象
             */
            data=JSON.parse(data);
            if(data.code==200){
                closeDlgData('dlg');
                searchByParams();
            }else{
                $.messager.alert("来自crm",data.msg,"error");
            }
        }
    })
}

//查询
function queryCustomerServesByParams() {
    $('#dg').datagrid('load',{
        cusName: $('#cusName').val(),
        myd: $('#myd').combobox('getValue'),
        time: $('#time').datebox('getValue')
    })
}