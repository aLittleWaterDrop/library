package com.wjl.library.services;

import com.wjl.library.Mapper.AdminMapper;
import com.wjl.library.bean.Admin;
import com.wjl.library.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @Description 这是
 * @create 2022-03-01 8:59
 */
@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public Admin checkAdmin(String username, String password) {
        Admin admin = adminMapper.getAdmin(username, password);
        return admin;
    }

    public void updateAdminPassword(Admin admin, String newPswd) {
        admin.setPassword(newPswd);
        adminMapper.updateAdmin(admin);
    }

    public Admin checkRootAdmin(Integer id) {
        return adminMapper.getRootAdmin(id);
    }

    public void saveAdminToAttribute(Model model) {
        List<Admin> admins = adminMapper.getAllAdmin();
        model.addAttribute("admins", admins);
    }

    public void addAdmin(Admin admin) {
        admin.setIsRoot(0);
        adminMapper.addAdmin(admin);
    }

    public void saveAdminByIdToAttribute(Integer id, Model model) {
        Admin adminById = adminMapper.getAdminById(id);
        model.addAttribute("adminById", adminById);
    }

    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }

    public void deleteAdmin(Integer adminId) {
        adminMapper.deleteAdminById(adminId);
    }

    public boolean checkAdminExist(Admin loginAdmin) {
        if (loginAdmin == null) return false;
        Admin adminById = adminMapper.getAdminById(loginAdmin.getId());
        return adminById != null;
    }
}
