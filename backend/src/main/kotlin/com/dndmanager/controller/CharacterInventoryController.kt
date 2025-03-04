package com.dndmanager.controller

import com.dndmanager.dto.CharacterInventoryCreateDTO
import com.dndmanager.dto.CharacterInventoryFindDTO
import com.dndmanager.dto.CharacterInventoryGetDTO
import com.dndmanager.dto.CharacterInventoryUpdateDTO
import com.dndmanager.service.CharacterInventoryService
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/session/character/inventory")
class CharacterInventoryController : BaseControllerImp<CharacterInventoryService, CharacterInventoryCreateDTO, CharacterInventoryUpdateDTO, CharacterInventoryGetDTO, CharacterInventoryFindDTO>() {

    @Inject override lateinit var service: CharacterInventoryService

    @GET
    @Path("/{id}")
    fun getPlayerInventory(id: Long) : List<CharacterInventoryFindDTO>{
        return service.getAllByCharacter(id)
    }
}