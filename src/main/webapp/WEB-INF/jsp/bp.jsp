<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/reports.css"/>">
</head>
<body>
	<div class="container">
		<h2>Blood Pressure</h2>
		<br>
		<form id="search_form_id" role="form">
			<div class='row'>
				<div class='col-sm-4'>
					<div class="form-group">
						<label for="submittime_from_p_id">Start Time:</label>
						<div class='input-group date' id='submittime_from_p_id'
							data-date-format="YYYY-MM-DD">
							<input type='text' class="form-control" id='submittime_from_id' />
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-calendar"></span> </span>
						</div>
					</div>
				</div>
				<div class='col-sm-4'>
					<div class="form-group">
						<label for="submittime_to_p_id">End Time:</label>
						<div class='input-group date' id='submittime_to_p_id'
							data-date-format="YYYY-MM-DD">
							<input type='text' class="form-control" id='submittime_to_id' />
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-calendar"></span> </span>
						</div>
					</div>
				</div>
			</div>
			<div class='row'>
				<div class='col-sm-3'>
					<button type="submit" id="searchBtn"
						class="form-control btn btn-default">Search</button>
				</div>
			</div>
			<br>
		</form>
		<table id="table_id2" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>MDate</th>
					<th>BPL</th>
					<th>HP</th>
					<th>HR</th>
					<th>IsArr</th>
					<th>LP</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>MDate</th>
					<th>BPL</th>
					<th>HP</th>
					<th>HR</th>
					<th>IsArr</th>
					<th>LP</th>
				</tr>
			</tfoot>
		</table>
		<script type="text/javascript" charset="utf8"
			src="//code.jquery.com/jquery.js"></script>
		<script type="text/javascript" charset="utf8"
			src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
		<script type="text/javascript" charset="utf8"
			src="//cdn.datatables.net/plug-ins/505bef35b56/integration/bootstrap/3/dataTables.bootstrap.js"></script>
		<script type="text/javascript" charset="utf8"
			src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.6.0/moment.min.js"></script>
		<script type="text/javascript" charset="utf8"
			src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" charset="utf8"
			src="<c:url value="/resources/js/reports.js"/>"></script>
	</div>
	<!-- /container -->
</body>
</html>