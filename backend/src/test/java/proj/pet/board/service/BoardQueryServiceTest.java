package proj.pet.board.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import proj.pet.board.domain.Board;
import proj.pet.board.domain.BoardMediaManager;
import proj.pet.board.dto.BoardInfoDto;
import proj.pet.board.dto.BoardsPaginationDto;
import proj.pet.board.repository.BoardCategoryFilterRepository;
import proj.pet.board.repository.BoardMediaRepository;
import proj.pet.board.repository.BoardRepository;
import proj.pet.category.domain.AnimalCategory;
import proj.pet.category.domain.Species;
import proj.pet.category.repository.AnimalCategoryRepository;
import proj.pet.comment.domain.Comment;
import proj.pet.comment.repository.CommentRepository;
import proj.pet.member.domain.Country;
import proj.pet.member.domain.Member;
import proj.pet.member.domain.MemberRole;
import proj.pet.member.domain.OauthProfile;
import proj.pet.member.domain.OauthType;
import proj.pet.member.repository.MemberRepository;
import proj.pet.reaction.domain.Reaction;
import proj.pet.reaction.domain.ReactionType;
import proj.pet.reaction.repository.ReactionRepository;
import proj.pet.scrap.domain.Scrap;
import proj.pet.scrap.repository.ScrapRepository;

@SpringBootTest
@Transactional
class BoardQueryServiceTest {

	@Autowired
	private BoardQueryService boardQueryService;

	@Autowired
	private EntityManager em;
	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BoardCategoryFilterRepository boardCategoryFilterRepository;

	@Autowired
	private BoardMediaRepository boardMediaRepository;

	private BoardMediaManager boardMediaManager;

	private BoardService boardService;

	@Autowired
	private AnimalCategoryRepository animalCategoryRepository;

	@Autowired
	private ReactionRepository reactionRepository;

	@Autowired
	private ScrapRepository scrapRepository;

	@Autowired
	private CommentRepository commentRepository;

	@BeforeEach
	void setUp() {
		boardMediaManager = mock(BoardMediaManager.class);
		boardService = new BoardServiceImpl(boardRepository, memberRepository,
				boardCategoryFilterRepository, boardMediaManager, boardMediaRepository,
				animalCategoryRepository);
	}

	@DisplayName("")
	@Test
	void test() {
		//given
		LocalDateTime now = LocalDateTime.now();
		Member author = memberRepository.save(stubMember("sanan", MemberRole.USER, now));
		Member loginUser = memberRepository.save(stubMember("hyungnoh", MemberRole.USER, now));
		animalCategoryRepository.saveAll(List.of(
				AnimalCategory.of(Species.CAT),
				AnimalCategory.of(Species.DOG),
				AnimalCategory.of(Species.ETC)));
		MultipartFile mockImageFile = mock(MultipartFile.class);
		MultipartFile mockVideoFile = mock(MultipartFile.class);
		when(mockImageFile.getContentType()).thenReturn("image/png");
		when(mockVideoFile.getContentType()).thenReturn("video/mp4");
		List<MultipartFile> mediaDtoList = List.of(
				mockImageFile,
				mockImageFile,
				mockVideoFile);
		when(boardMediaManager.uploadMedia(mockImageFile)).thenReturn("imagePath");
		when(boardMediaManager.uploadMedia(mockVideoFile)).thenReturn("videoPath");
		List<Species> speciesList = List.of(Species.CAT, Species.DOG, Species.ETC);
		Board board = boardService.createBoard(author.getId(), speciesList, mediaDtoList, "content",
				now);
		em.flush();
		em.clear();
		reactionRepository.save(Reaction.of(board, loginUser, ReactionType.LIKE, now));
		scrapRepository.save(Scrap.of(loginUser, board, now));
		commentRepository.save(Comment.of(board, loginUser, "야 귀엽다", now));
		em.flush();
		em.clear();

		//when
		BoardsPaginationDto result = boardQueryService.getMainViewBoards(loginUser.getId(),
				PageRequest.of(0, 10));

		//then
		assertThat(result).isNotNull();
//		assertThat(result.getTotalLength()).isEqualTo(1); <- Page<>를 쓰기 힘듦.. ToDo
		BoardInfoDto boardInfoDto = result.getResult().get(0);
		assertThat(boardInfoDto.getBoardId()).isEqualTo(board.getId());
		assertThat(boardInfoDto.getMemberName()).isEqualTo(author.getNickname());
		assertThat(boardInfoDto.getCategories()).isEqualTo(speciesList);
		assertThat(boardInfoDto.getImages().size()).isEqualTo(3);
		assertThat(boardInfoDto.getPreviewComment()).isEqualTo("야 귀엽다");


	}

	private Member stubMember(String nickname, MemberRole memberRole, LocalDateTime now) {
		OauthProfile oauthProfile = OauthProfile.of(OauthType.FORTY_TWO, "oauthId", "oauthName");
		return Member.of(oauthProfile,
				Country.KOREA,
				nickname,
				"statement",
				memberRole,
				now);
	}

}