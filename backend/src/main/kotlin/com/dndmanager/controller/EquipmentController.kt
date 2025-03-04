package com.dndmanager.controller

import com.dndmanager.dto.EquipmentCreateDTO
import com.dndmanager.dto.EquipmentFindDTO
import com.dndmanager.dto.EquipmentGetDTO
import com.dndmanager.dto.EquipmentUpdateDTO
import com.dndmanager.service.EquipmentService
import jakarta.inject.Inject
import jakarta.ws.rs.Path

@Path("/equipment")
class EquipmentController :
    BaseControllerImp<EquipmentService, EquipmentCreateDTO, EquipmentUpdateDTO, EquipmentGetDTO, EquipmentFindDTO>() {

    @Inject override lateinit var service: EquipmentService
}