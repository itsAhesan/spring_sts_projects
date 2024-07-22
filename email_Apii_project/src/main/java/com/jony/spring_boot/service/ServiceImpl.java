package com.jony.spring_boot.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jony.spring_boot.model.Email;
import com.jony.spring_boot.model.Member;
import com.jony.spring_boot.repository.EmailRepo;
import com.jony.spring_boot.repository.MemberRepo;

@Service
public class ServiceImpl implements MemberService{

	@Autowired
	private MemberRepo repo;
	@Autowired
	private EmailRepo eRepo;
	
	@Override
	public Member add(Member member) {
		Member save = repo.save(member);
		
		return save;
		
	}
	@Override
	public Member checkMember(String name, String pass) {
		Member findByName = repo.findByName(name,pass);
		
		return findByName;
	}
	@Override
	public Member send(String to) {
		Member findBy = repo.findBy(to);
		return findBy;
		
	}
	@Override
	public void save(Email email) {
		eRepo.save(email);
		
	}
	@Override
	public void relation(int id, int id2) {
		Member member = repo.findById(id).orElse(null);
		
		Email email = eRepo.findById(id2).orElse(null);
		

		
		member.getEmail().add(email);
		repo.save(member);
		
		
	}
	@Override
	public Member checkName(String name) {
		
		Member findBymName = repo.findBymName(name);
			
		return findBymName;
	}
	
	/*
	 * @Override public Email sentEmail(String from) { Email findByName =
	 * eRepo.findByName(from); System.out.println(findByName); return findByName; }
	 */

}
