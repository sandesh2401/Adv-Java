<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">
      <div class="alert alert-primary" role="alert">
        Update form for student
      </div>
    </div>
    <div class="container mt-5">
      <form action="StudentUpdateController" method="post">
        <div class="row">
          <div class="col-lg-4">
            <div class="mb-3">
              <label for="id" class="form-label">Id</label>
              <input type="text" class="form-control" id="id" name="id" value="${student.id}" readonly>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="mb-3">
              <label for="name" class="form-label">Name</label>
              <input type="text" class="form-control" id="name" name="name" value="${student.name}" required>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-4">
            <div class="mb-3">
              <label for="marks" class="form-label">Marks</label>
              <input type="number" step="0.01" class="form-control" id="marks" name="marks" value="${student.marks}" required>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="mb-3">
              <label for="phone" class="form-label">Phone</label>
              <input type="text" class="form-control" id="phone" name="phone" value="${student.phone}" required>
            </div>
          </div>
        </div>
    <!--      <div class="row">
          <div class="col-lg-4">
            <div class="form-check">
              <input class="form-check-input" type="radio" name="gender" id="gender-m" value="male" ${student.gender == 'male' ? 'checked' : ''}>
              <label class="form-check-label" for="gender-m">Male</label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="gender" id="gender-f" value="female" ${student.gender == 'female' ? 'checked' : ''}>
              <label class="form-check-label" for="gender-f">Female</label>
            </div>
          </div> -->
          <div class="col-lg-4">
            <select class="form-select" aria-label="Default select example" name="city" required>
              <option ${student.city == 'Mumbai' ? 'selected' : ''}>Mumbai</option>
              <option ${student.city == 'Delhi' ? 'selected' : ''}>Delhi</option>
              <option ${student.city == 'Pune' ? 'selected' : ''}>Pune</option>
            </select>
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-lg-4">
            <input type="submit" class="btn btn-success" value="Update">
          </div>
        </div>
      </form>
    </div>
    <div class="container mt-3">
      <div class="row">
        <div class="col-lg-4">
          <%
            if(request.getAttribute("msg") != null) {
          %>
              <div class="alert alert-success" role="alert">
                <%= request.getAttribute("msg") %>
              </div>
          <%
            }
            if(request.getAttribute("errorMsg") != null) {
          %>
              <div class="alert alert-danger" role="alert">
                <%= request.getAttribute("errorMsg") %>
              </div>
          <%
            }
          %>
        </div>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>
