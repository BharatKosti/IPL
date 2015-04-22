<%--
  Created by IntelliJ IDEA.
  User: bharatkosti
  Date: 4/22/15
  Time: 12:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-offset-1 col-sm-10">

  <legend>
    <spring:message code="table.bowlers.title" />
  </legend>

  <div>
    <table id="dataTable1" class="table table-striped table-bordered">
      <thead>
      <tr>
        <th><spring:message code="table.bowlers.id" /></th>
        <th><spring:message code="table.bowlers.name" /></th>
        <th><spring:message code="table.bowlers.bowlingAvg" /></th>
        <th><spring:message code="table.bowlers.bestFigures" /></th>
        <th><spring:message code="table.bowlers.wickets" /></th>
        <th><spring:message code="table.bowlers.matches" /></th>
      </tr>
      <thead>
      <tbody>
      <c:forEach var="bo" items="${bowlers}">
      <tr>
        <td>${bo.id}</td>
        <td>${bo.name}</td>
        <td>${bo.bowlingAvg}</td>
        <td>${bo.bestFigures}</td>
        <td>${bo.wickets}</td>
        <td>${bo.matches}</td>
      <tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<div class="col-sm-offset-1 col-sm-10">

  <legend>
    <spring:message code="table.batsmen.title" />
  </legend>

  <div>
    <table id="dataTable2" class="table table-striped table-bordered">
      <thead>
      <tr>
        <th><spring:message code="table.batsmen.id" /></th>
        <th><spring:message code="table.batsmen.name" /></th>
        <th><spring:message code="table.batsmen.battingAvg" /></th>
        <th><spring:message code="table.batsmen.bestScore" /></th>
        <th><spring:message code="table.batsmen.runs" /></th>
        <th><spring:message code="table.batsmen.matches" /></th>
      </tr>
      <thead>
      <tbody>
      <c:forEach var="bt" items="${batsmen}">
      <tr>
        <td>${bt.id}</td>
        <td>${bt.name}</td>
        <td>${bt.battingAvg}</td>
        <td>${bt.bestScore}</td>
        <td>${bt.runs}</td>
        <td>${bt.matches}</td>
      <tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>
