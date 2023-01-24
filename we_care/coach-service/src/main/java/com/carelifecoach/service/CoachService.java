package com.carelifecoach.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.carelifecoach.dto.CoachDTO;
import com.carelifecoach.entity.Coach;
import com.carelifecoach.register.RegisterCoachRequest;
import com.carelifecoach.repository.CoachRepository;
import com.carelifecoach.response.CoachResponse;

import antlr.collections.List;
@Service
public class CoachService {
	@Autowired
	CoachRepository coachRepository;

	public CoachResponse registerCoach(RegisterCoachRequest registerUserRequest) {
		
		Coach coach = new Coach();
		coach.setName(registerUserRequest.getName());
		coach.setPassword(registerUserRequest.getPassword());
		coach.setDateofbirth(registerUserRequest.getDateofbirth());
		coach.setGender(registerUserRequest.getGender());
		coach.getMobilenumber();
		coachRepository.save(coach);
		
		return new CoachResponse(coach);
		
	}

	public String getLoginById(long id, String username, String password) {

		
		
		Coach coach=coachRepository.findById(id).get();
		if (coach.getName().equals(username) && coach.getPassword().equals(password))
	      return username+"Login Successfully";
		else 
			return "Invalid Login and not a register user";
		
	
	}
	public Boolean loginUser( @RequestBody CoachDTO user) throws Exception{
		java.util.Optional<Coach> userEntity = coachRepository.findById(user.getId());
		if(userEntity.isPresent()) 
			return userEntity.get().getPassword().equals(user.getPassword());
		else
			throw new Exception("user not found");
			
	}
	public CoachDTO getCoachProfile(Long coachId) throws Exception{
		Coach coach  = coachRepository.findById(coachId).get();
		
	return new CoachDTO(coach);
		}

		
	

	public ArrayList<CoachDTO> showAllCoaches()  {
		Iterable<Coach> coaches = coachRepository.findAll();
		ArrayList<CoachDTO> coaches2 = new ArrayList<CoachDTO>(); 
		
		coaches.forEach(coach -> {
			CoachDTO coch = new CoachDTO();
			coch.setId(coach.getId());
			coch.setName(coach.getName());
			coch.setPassword(coach.getPassword());
			coch.setMobilenumber(coach.getMobilenumber());
			coch.setGender(coach.getGender());
			coch.setDateofbirth(coach.getDateofbirth());
			coch.setSpeciality(coach.getSpeciality());
			
			
		   
			coaches2.add(coch);
		});
	
		return coaches2;
		
	}
		
}
	
	