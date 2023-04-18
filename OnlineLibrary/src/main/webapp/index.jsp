<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
table, th, td, tr {
	border: 1px solid black;
}
</style>
<script>
function displaySpecific() {
	document.getElementById("collapse3content").innerHTML = "";
	var id = document.getElementById("id2").value;
	fetch('webapi/libresource/book/'+id)
	.then((res) => res.json())
	.then((x) => {
	var html = "<table style='width:100%'><tr><th>ID</th><th>Book Name</th><th>Author Name</th><th>Book Price</th><th>Book Genre</th><th>Publishing Date</th></tr>";
	html += "<tr style='width:100%'><td>" + x['id'] + "</td><td>" + x['name'] + "</td><td>" + x['author'] + "</td><td>" + x['price'] + "</td><td>" + x['genre'] + "</td><td>" + x['pub_date'] + "</td></tr>";
	html += "</table>";
	document.getElementById("collapse3content").innerHTML = html;
	});
}
function displayAll(){
	fetch('webapi/libresource/books')
	.then((res) => res.json())
	.then((x) => {
	var html = "<div class='panel-body'><table style='width:100%'><tr><th>ID</th><th>Book Name</th><th>Author Name</th><th>Book Price</th><th>Book Genre</th><th>Publishing Date</th></tr>";
	for (var i = 0; i < x.length; i += 1) {
	html += "<tr style='width:100%'><td>" + x[i]['id'] + "</td><td>" + x[i]['name'] + "</td><td>" + x[i]['author'] + "</td><td>" + x[i]['price'] + "</td><td>" + x[i]['genre'] + "</td><td>" + x[i]['pub_date'] + "</td></tr>";
	}
	html += "</table></div>";
	document.getElementById("collapse2").innerHTML = html;
	});
}
function createBook(){
	var id = document.getElementById("id").value;
	var name = document.getElementById("name").value;
	var author = document.getElementById("author").value;
	var price = document.getElementById("price").value;
	var genre = document.getElementById("genre").value;
	var pub_date = document.getElementById("pub_date").value;
	fetch('webapi/libresource/insert/'+id+'/'+name+'/'+author+'/'+price+'/'+genre+'/'+pub_date,{
		method: "POST"
	})
	.then((res) => res.text())
    .then((text) => {
        alert(text);
      });
}
function updateBook(){
	var id = document.getElementById("id3").value;
	var name = document.getElementById("name3").value;
	var author = document.getElementById("author3").value;
	var price = document.getElementById("price3").value;
	var genre = document.getElementById("genre3").value;
	var pub_date = document.getElementById("pub_date3").value;
	fetch('webapi/libresource/update/'+id+'/'+name+'/'+author+'/'+price+'/'+genre+'/'+pub_date,{
		method: "POST"
	})
	.then((res) => res.text())
    .then((text) => {
        alert(text);
      });
}
function deleteBook(){
	var id = document.getElementById("id4").value;
	fetch('webapi/libresource/delete/'+id,{
		method: "POST"
	})
	.then((res) => res.text())
    .then((text) => {
        alert(text);
      });
}
</script>
</head>
<body>

	<div class="container">
		<h2>Online Library</h2>
		<p>Click to perform the desired action</p>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" href="#collapse1">Click to add book</a>
					</h4>
				</div>
				<div id="collapse1" class="panel-collapse collapse">
					<div class="panel-body">
						<form>
							<div class="form-group">
								<label for="id">ID</label> <input type="number"
									class="form-control" id="id" placeholder="Enter ID">
							</div>
							<div class="form-group">
								<label for="name">Book Name</label> <input type="text"
									class="form-control" id="name" placeholder="Enter Book Name">
							</div>
							<div class="form-group">
								<label for="author">Author</label> <input type="text"
									class="form-control" id="author" placeholder="Enter Author">
							</div>
							<div class="form-group">
								<label for="price">Price</label> <input type="number"
									class="form-control" id="price" placeholder="Enter price">
							</div>
							<div class="form-group">
								<label for="genre">Genre</label> <input type="text"
									class="form-control" id="genre" placeholder="Enter Genre">
							</div>
							<div class="form-group">
								<label for="pub_date">Publishing Date</label> <input type="text"
									class="form-control" id="pub_date"
									placeholder="Enter Publishing Date">
							</div>
							<button type="button" class="btn btn-primary"
								onclick="createBook()">Create Book</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" href="#collapse2" onclick="displayAll()">Click
							to display all books</a>
					</h4>
				</div>
				<div id="collapse2" class="panel-collapse collapse"></div>
			</div>
		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" href="#collapse3">Click to display
							specific book</a>
					</h4>
				</div>
				<div id="collapse3" class="panel-collapse collapse">
					<div class="panel-body">
						<form>
							<div class="form-group">
								<label for="id2">ID</label> <input type="number"
									class="form-control" id="id2" placeholder="Enter ID">
							</div>
							<button type="button" onclick="displaySpecific()"
								class="btn btn-primary">Display Book</button>
						</form>
					</div>
					<div class="panel-footer" id="collapse3content"></div>
				</div>
			</div>
		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" href="#collapse4">Click to update
							book</a>
					</h4>
				</div>
				<div id="collapse4" class="panel-collapse collapse">
					<div class="panel-body">
						<form>
							<div class="form-group">
								<label for="id3">ID</label> <input type="number"
									class="form-control" id="id3" placeholder="Enter ID">
							</div>
							<div class="form-group">
								<label for="name3">Book Name</label> <input type="text"
									class="form-control" id="name3" placeholder="Enter Book Name">
							</div>
							<div class="form-group">
								<label for="author3">Author</label> <input type="text"
									class="form-control" id="author3" placeholder="Enter Author">
							</div>
							<div class="form-group">
								<label for="price3">Price</label> <input type="number"
									class="form-control" id="price3" placeholder="Enter price">
							</div>
							<div class="form-group">
								<label for="genre3">Genre</label> <input type="text"
									class="form-control" id="genre3" placeholder="Enter Genre">
							</div>
							<div class="form-group">
								<label for="pub_date3">Publishing Date</label> <input
									type="text" class="form-control" id="pub_date3"
									placeholder="Enter Publishing Date">
							</div>
							<button type="button" class="btn btn-primary"
								onclick="updateBook()">Update Book</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" href="#collapse5">Click to delete
							book</a>
					</h4>
				</div>
				<div id="collapse5" class="panel-collapse collapse">
					<div class="panel-body">
						<form>
							<div class="form-group">
								<label for="id4">ID</label> <input type="number"
									class="form-control" id="id4" placeholder="Enter ID">
							</div>
							<button type="button" class="btn btn-primary" onclick="deleteBook()">Delete
								Book</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>