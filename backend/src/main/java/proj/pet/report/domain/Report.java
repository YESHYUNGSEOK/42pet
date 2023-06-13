package proj.pet.report.domain;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import proj.pet.board.domain.Board;
import proj.pet.member.domain.Member;

@NoArgsConstructor(access = PROTECTED)
@Entity
@Getter
public class Report {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member from;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "reported_member_id", nullable = false)
	private Member to;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "board_id", nullable = false)
	private Board board;

	@Column(name = "reason", nullable = false)
	private ReportReason reason;

	@Column(name = "content", nullable = false, length = 255)
	private String content;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

}
