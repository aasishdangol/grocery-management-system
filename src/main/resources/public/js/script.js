$(function () {

    // Start counting from the third row

    $("#insertRow").on("click", function (event) {
        event.preventDefault();

        var newRow = $("<tr>");
        var cols = '';

        // Table columns
        cols += '<td><select class="form-control rounded-0"> <option th:each="product: *{productList}" th:value="${product.id}" th:text="${product.name}">Products</option></select></td>';
        cols += '<td><input  class="form-control rounded-0" type="number" name="price" placeholder="Price"></td>';
        cols += '<td><input class="form-control rounded-0" type="number" name="quantity" placeholder="Quantity"></td>';
        cols += '<td><input class="form-control rounded-0" type="number" name="total" placeholder="total"></td>';
        cols += '<td><button class="btn btn-danger rounded-0" id ="deleteRow"><i class="fa fa-trash"></i></button></td>';

        // Insert the columns inside a row
        newRow.append(cols);

        // Insert the row inside a table
        $("table").append(newRow);

        // Increase counter after each row insertion
        counter++;
    });

    // Remove row when delete btn is clicked
    $("table").on("click", "#deleteRow", function (event) {
        $(this).closest("tr").remove();
        counter -= 1
    });
});
