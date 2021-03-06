/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnt.service;

import com.rnt.model.RepairStatus;
import java.util.List;

/**
 *
 * @author Nuno
 */
public interface RepairStatusService {
    
    RepairStatus findById(int id);
    
    void saveRepairStatus(RepairStatus repairStatus);
    
    void deleteRepairStatusById(int id);
    
    List<RepairStatus> listRepairStatus();
    
    void updateRepairStatus(RepairStatus repairStatus);
    
}
