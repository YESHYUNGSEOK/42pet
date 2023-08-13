package proj.pet.scrap.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import proj.pet.board.domain.Board;
import proj.pet.member.domain.Member;
import proj.pet.utils.domain.IdDomain;
import proj.pet.utils.domain.RuntimeExceptionThrower;
import proj.pet.utils.domain.Validatable;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "SCRAP")
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Scrap extends IdDomain implements Validatable {

	@Column(name = "MEMBER_ID", nullable = false, updatable = false)
	private Long memberId;

	@Column(name = "BOARD_ID", nullable = false, updatable = false)
	private Long boardId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_ID", nullable = false, updatable = false)
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOARD_ID", nullable = false, updatable = false)
	private Board board;

	@Column(name = "CREATED_AT", nullable = false)
	private LocalDateTime createdAt;

	private Scrap(Member member, Board board, LocalDateTime now) {
		this.member = member;
		this.board = board;
		this.createdAt = now;
		RuntimeExceptionThrower.checkValidity(this);
	}

	public static Scrap of(Member member, Board board, LocalDateTime now) {
		return new Scrap(member, board, now);
	}

	@Override public boolean isValid() {
		return member != null
				&& !member.isNew()
				&& board != null
				&& !board.isNew()
				&& createdAt != null;
	}
}
