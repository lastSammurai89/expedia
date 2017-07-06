<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Hotels Info</title>
</head>
<body>

Search For The Hotels By 
<form action="Controller">
<select name="searchOption">
	<option value="destinationCity" ${param.searchOption eq 'destinationCity' ? 'selected' : ''}>Destination City</option>
	<option value="regionIds" ${param.searchOption eq 'regionIds' ? 'selected' : ''}>regionIds</option>
	<option value="lengthOfStay" ${param.searchOption eq 'lengthOfStay' ? 'selected' : ''}>lengthOfStay</option>
	<option value="minmaxStarRating" ${param.searchOption eq 'minmaxStarRating' ? 'selected' : ''}>minmax Star Rating</option>
	<option value="minmaxTotalRate" ${param.searchOption eq 'minmaxTotalRate' ? 'selected' : ''}>min max Total Rate</option>
	<option value="minMaxGuestRating" ${param.searchOption eq 'minMaxGuestRating' ? 'selected' : ''}>min Max Guest Rating</option>
</select>
<input type=text name="searchValue"> 
<input type="submit" name="searchBtn" value="search"> 
</form>

<c:if test="${not empty param.searchValue}">
	<p>You searched for ${param.searchValue}</p>
</c:if>


<p><br>Number of founded results : ${resultNumber}<br></p>

<table border="0">
<tr>
	 <td>hotelId</td>
	 <td>hotelName</td>

	
	
	 <td>hotelDestinationStr</td>
	 <td>hotelDestinationRegionID </td>
	 <td>hotelLongDestination </td>
	 <td>hotelStreetAddress </td>
	 <td>hotelCity</td>
	 <td>hotelProvince </td>
	 <td>hotelCountryCode </td>
	 <td>hotelLocation</td>
	 <td>hotelLatitude </td>
	 <td>hotelLongitude</td>
	 <td>hotelStarRating </td>

 <td>hotelGuestReviewRating</td>
 <td>hotelInfotravelStartDate</td>
 <td>hotelInfotravelEndDate</td>
 <td>hotelImageUrl</td>
 <td>carPackageScore</td>
 <td>description</td>
 <td>distanceFromUser</td>
 <td>language</td>
 <td>movingAverageScore</td>
 <td>promotionAmount</td>
 <td>promotionDescription</td>
 <td>promotionTag</td>
 <td>rawAppealScore</td>
</tr>
<c:forEach var="hotel" items="${hotels}">
	<tr>
	 <td>${hotel.hotelId};</td>
	 <td>${hotel.hotelName}; </td>

	
	
	 <td>${hotel.hotelDestinationStr};</td>
	 <td>${hotel.hotelDestinationRegionID}; </td>
	 <td>${hotel.hotelLongDestination}; </td>
	 <td>${hotel.hotelStreetAddress}; </td>
	 <td>${hotel.hotelCity};</td>
	 <td>${hotel.hotelProvince}; </td>
	 <td>${hotel.hotelCountryCode}; </td>
	 <td>${hotel.hotelLocation};</td>
	 <td>${hotel.hotelLatitude}; </td>
	 <td>${hotel.hotelLongitude};</td>
	 <td>${hotel.hotelStarRating}; </td>

 <td>${hotel.hotelGuestReviewRating}; </td>
 <td>${hotel.hotelInfotravelStartDate}; </td>
 <td>${hotel.hotelInfotravelEndDate}; </td>
 <td>${hotel.hotelImageUrl}; </td>
 <td>${hotel.carPackageScore};</td>
 <td>${hotel.description}; </td>
 <td>${hotel.distanceFromUser}; </td>
 <td>${hotel.language}; </td>
 <td>${hotel.movingAverageScore}; </td>
 <td>${hotel.promotionAmount}; </td>
 <td>${hotel.promotionDescription}; </td>
 <td>${hotel.promotionTag};</td>
 <td>${hotel.rawAppealScore};</td>
</tr>
	
</c:forEach>

</table>
</body>
</html>