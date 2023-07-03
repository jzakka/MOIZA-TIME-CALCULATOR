package com.ll.moizatimecalculator.boundedContext.room.repository;

import com.ll.moizatimecalculator.boundedContext.member.entity.Member;
import com.ll.moizatimecalculator.boundedContext.room.entity.EnterRoom;
import com.ll.moizatimecalculator.boundedContext.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EnterRoomRepository extends JpaRepository<EnterRoom, Long> {
    Optional<EnterRoom> findByRoomAndMember(Room room, Member member);

    @Query(value = "select er.member from EnterRoom as er where er.room = ?1 order by er.member")
    List<Member> findMembersByRoom(Room room);

    Optional<EnterRoom> findByMemberIdAndRoomId(Long memberId, Long roomId);
}
