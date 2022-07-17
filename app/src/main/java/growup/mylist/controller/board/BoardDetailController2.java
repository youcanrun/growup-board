package growup.mylist.controller.board;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import growup.mylist.domain.Board;
import growup.mylist.service.BoardService;

//@SuppressWarnings("serial")
//@WebServlet("/board/detail") 
public class BoardDetailController2 extends HttpServlet {

  BoardService boardService;



  @Override
  public void init() throws ServletException {
    ServletContext 웹애플리케이션보관소 = this.getServletContext();
    boardService = (BoardService) 웹애플리케이션보관소.getAttribute("boardService");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      Board board = boardService.get(no);
      request.setAttribute("board", board);
      request.setAttribute("viewUrl", "/jsp/board/detail.jsp");

    } catch (Exception e) {
      request.setAttribute("exception", e);
    }
  }
}
