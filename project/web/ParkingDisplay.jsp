<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<s:include value="/Header.jsp"></s:include>

<div id="center">     
    <div id="center_page_name">
        Gestion des parkings
    </div>
    <div id="center_content">
        <table align=center class="table_t" style="margin-top:120px;">
            <tr class=tableTr>
                <th>Name</th>
                <th>Parking Number</th>
                <th>Category</th>
                <th>Empty/Full</th>
            </tr>
            <s:iterator value="p_list" status="parkingStatus">
                <tr class=tableTdGreen>
                    <td><s:property value="parking_name"/></td>
                    <td><s:property value="parking_number"/></td>
                    <td><s:property value="category.cat_name"/></td>
                    <td>
                        <s:if test="parking_empty == true">Empty</s:if >
                        <s:else>Full</s:else>
                    </td>
                </tr>
            </s:iterator>

        </table>
    </div>
</div>

<s:include value="/Footer.jsp"></s:include>
