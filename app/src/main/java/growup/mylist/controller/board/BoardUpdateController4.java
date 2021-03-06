package growup.mylist.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import growup.mylist.controller.RequestMapping;
import growup.mylist.domain.Board;
import growup.mylist.domain.Member;
import growup.mylist.service.BoardService;

//@Component("/board/update")
public class BoardUpdateController4  {

  BoardService boardService;

  public BoardUpdateController4(BoardService boardService) {
    this.boardService = boardService;
  }

  @RequestMapping
  public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    board.setWriter(loginUser);

    boardService.update(board);

    return "redirect:list";

  } 
}
