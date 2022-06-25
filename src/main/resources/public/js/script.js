$(function () {

    // Start counting from the third row

    $("#insertRow").on("click", function (event) {
        event.preventDefault();

//        var previousRow = document.getElementById("productTable").rows.length;

        var newRow = $("<tr>");
        var cols = '';

        // Table columns
        cols += ' <td><select id="mySelect1" name="mySelect1" onChange="myFunction()" class="form-control rounded-0"name="|sales.productList[0].name|"> <option class="form-control">---Product---</option> <option each="product: *{productList}"value="${product.id}"text="${product.name}">Products </option> </select></td>; '
        cols += '<td><input  class="form-control rounded-0" type="number" name="price1" id="price1" placeholder="Price" disabled></td>';
        cols += '<td><input class="form-control rounded-0" type="number" name="quantity1"id="quantity1" placeholder="Quantity"></td>';
        cols += '<td><input class="form-control rounded-0" type="number" name="total1"id="total1" placeholder="total"disabled></td>';
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
