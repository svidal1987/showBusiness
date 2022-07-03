package com.show.business.tecnica.transferobject;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRs extends Respuesta {
	String user;
	String token;
}
