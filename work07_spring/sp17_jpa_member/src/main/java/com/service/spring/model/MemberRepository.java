package com.service.spring.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.service.spring.domain.Member;

// 이전의 MemberDAO에 해당
public interface MemberRepository extends JpaRepository<Member, String>{
	
	/*
	 * 제공되는 CRUD
	 * C, U: save()---registerMember, updateMember
	 * D : delete()---deleteMember
	 * R : count()
	 * R : findAll()---showAll
	 * ------------------------
	*/
	
	/*
	 * 추가로 작성해야 하는 쿼리문.. 옵션이 필요하다.
	 * login
	 * findByIdMember
	 * updateMember
	 * String idExist(String id)
	 */
	
	/*
	 * @Query(value = "select * from board where id=? and password = ?" ,
	 * nativeQuery = true) //Entity중심이아닌 DB중심으로 쿼리를 작성함 Member login(Member member);
	 */

	@Query(value = "select id from member where id=?", nativeQuery = true)
	String idExist(String id);
	
	@Query(value = "select id, password, name, address from member where id=?", nativeQuery = true)
	Member findByIdMember(String id);
	
	// nativeQuery는 파라미터가 기본형일 때 가능하다.
	
	// nativeQuery는 파라미터가 객체일 때 불가능하다.	
	// @Param(테이블명)
	
	// 반드시 테이블Alias를 줘야한다.
	@Query("select from Member m where m.id=:#{#member.id} AND m.password=:#{#member.password}")
	Member login(@Param("member") Member member);
}
