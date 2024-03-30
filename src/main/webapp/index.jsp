<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<head>
    <title>Программист</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="flex-container">
    <c:if test="${!requestScope.developerList.isEmpty()}">
        <table>
            <thead>
            <tr>
                <th>Имя</th>
                <th>Опыт</th>
                <th>Должность</th>
                <th>Основная технология</th>
                <th>Зарплата</th>
            </tr>
            </thead>
            <c:forEach var="developer" items="${requestScope.developerList}">
                <tr>
                    <td>${developer.name}</td>
                    <td>${developer.experience}</td>
                    <td>${developer.position}</td>
                    <td>${developer.mainTechnology}</td>
                    <td>${developer.salary}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>


<div class="flex-container">
    <form action="${pageContext.request.contextPath}/add-developer" method="post">
        <fieldset>
            <legend>Добавление разработчика</legend>
            <div>
                <label>Имя: <input type="text" name="name" required></label>
            </div>
            <div>
                <label>Опыт: <input type="text" name="experience" required></label>
            </div>
            <div>
                <label>Должность: <input type="text" name="position" required></label>
            </div>
            <div>
                <label>Основная технология: <input type="text" name="mainTechnology" required></label>
            </div>
            <div>
                <label>Зарплата: <input type="number" min="0" step="10" name="salary" required></label>
            </div>
        </fieldset>
        <div>
            <input type="submit" value="Добавить">
        </div>
    </form>

    <form action="${pageContext.request.contextPath}/remove-developer" method="post">
        <fieldset>
            <legend>Удаление разработчика</legend>
            <div>
                <select name="developer-id">
                    <c:forEach var="developer" items="${requestScope.developerList}">
                        <option selected value="${developer.name}">${developer.name}</option>
                    </c:forEach>
                </select>
            </div>
        </fieldset>
        <div>
            <input type="submit" value="Удалить">
        </div>
    </form>
</div>

<div class="flex-container">

    <form action="${pageContext.request.contextPath}/filter-developer" method="post">
        <fieldset>
            <legend>Вывод программистов по должности</legend>
            <div>
                <select name="developer-id">
                    <c:forEach var="developer" items="${requestScope.developerList}">
                        <option selected value="${developer.position}">${developer.position}</option>
                    </c:forEach>
                </select>
            </div>
        </fieldset>
        <div>
            <input type="submit" value="Вывод"/>
            <input type="submit" name="reset" value="Сбросить"/>
        </div>
    </form>

    <form action="${pageContext.request.contextPath}/find-developer" method="post">
        <label>Сомый высокооплачиваемый программист</label>
        <div>
            <input type="submit" value="Поиск"/>
            <input type="submit" name="reset" value="Сбросить"/>
        </div>
    </form>
</div>


</body>
</html>
