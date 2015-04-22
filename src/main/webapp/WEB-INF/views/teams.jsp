<%--
  Created by IntelliJ IDEA.
  User: bharatkosti
  Date: 4/21/15
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-offset-1 col-sm-10">

  <legend>
    <spring:message code="table.teams.title" />
  </legend>

  <div>
    <table id="dataTable" class="table table-striped table-bordered">
      <thead>
      <tr>
        <th><spring:message code="table.teams.id" /></th>
        <th><spring:message code="table.teams.name" /></th>
        <th><spring:message code="table.teams.wins" /></th>
        <th><spring:message code="table.teams.losses" /></th>
        <th><spring:message code="table.teams.matches" /></th>
      </tr>
      <thead>
      <tbody>
      <c:forEach var="t" items="${teams}">
      <tr>
        <td>${t.id}</td>
        <td>${t.name}</td>
        <td>${t.wins}</td>
        <td>${t.losses}</td>
        <td>${t.matches}</td>
      <tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>
