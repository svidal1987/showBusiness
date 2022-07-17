package com.show.business.tecnica.dto;

import java.util.List;

import com.show.business.tecnica.model.Ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@AllArgsConstructor
@Getter@Setter
public class DisponibilidadRs {
	List<Ticket> tickets;
}
