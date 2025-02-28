package com.dndmanager.controller

import com.dndmanager.dto.*
import com.dndmanager.service.AbilityService
import jakarta.inject.Inject
import jakarta.ws.rs.Path

@Path("/ability")
class AbilityController :
    BaseControllerImp<AbilityService, AbilityCreateDTO, AbilityUpdateDTO, AbilityGetDTO, AbilityFindDTO>() {

    @Inject override lateinit var service: AbilityService
}