<%@page import="growup.mylist.domain.Member"%>
<%@page import="growup.mylist.domain.Board"%>
<%@page import="growup.mylist.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  Board board = new Board();
  board.setTitle(request.getParameter("title"));
  board.setContent(request.getParameter("content"));

  Member loginUser = (Member) session.getAttribute("loginUser");
  board.setWriter(loginUser);

  BoardService boardService = (BoardService) application.getAttribute("boardService");
  boardService.add(board);

  response.sendRedirect("list.jsp");
%>