package com.dndmanager.controller

import com.dndmanager.dto.SessionCreatDTO
import com.dndmanager.dto.SessionFindDTO
import com.dndmanager.dto.SessionGetDTO
import com.dndmanager.dto.SessionUpdateDTO
import com.dndmanager.service.SessionService
import jakarta.inject.Inject
import jakarta.ws.rs.Path

@Path("/sessions")
class SessionController : BaseControllerImp<SessionService, SessionCreatDTO, SessionUpdateDTO, SessionGetDTO, SessionFindDTO>() {

    @Inject override lateinit var service: SessionService
}