package com.mapsa.test.test.structure.proxy;

public class ProxyInternetAccess implements OfficeInternetAccess {
    private String employeeName;
    private RealInternetAccess realInternetAccess;
    public ProxyInternetAccess(String empName) {
        this.employeeName = empName;
    }
// alinorouzi79
    private int getRole(String empname) {
        // Check Role from Database
        // Return job level
        return 3;
    }

    @Override
    public void grantInternetAccess() {
        if (getRole(employeeName) > 2) {
            realInternetAccess = new RealInternetAccess(employeeName);
            realInternetAccess.grantInternetAccess();
        } else {
            System.err.println("No Internet access granted!");
        }
    }
}
