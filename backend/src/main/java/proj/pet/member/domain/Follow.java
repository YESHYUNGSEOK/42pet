package proj.pet.member.domain;

import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import proj.pet.utils.domain.MemberCompositeKey;

@NoArgsConstructor(access = PROTECTED)
@Entity
@Table(name = "FOLLOW")
@Getter
public class Follow {

	@EmbeddedId
	private MemberCompositeKey id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false, updatable = false, insertable = false)
	private Member from;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "target_member_id", nullable = false, updatable = false, insertable = false)
	private Member to;

	@Column(name = "followed_at", nullable = false)
	private LocalDateTime followedAt;
}