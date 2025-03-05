package com.dndmanager.controller

import com.dndmanager.dto.NpcCreateDTO
import com.dndmanager.dto.NpcFindDTO
import com.dndmanager.dto.NpcGetDTO
import com.dndmanager.dto.NpcUpdateDTO
import com.dndmanager.service.NpcService
import jakarta.inject.Inject
import jakarta.ws.rs.Path

@Path("/npc")
class NpcController : BaseControllerImp<NpcService, NpcCreateDTO, NpcUpdateDTO, NpcGetDTO, NpcFindDTO>() {

    @Inject override lateinit var service: NpcService
}