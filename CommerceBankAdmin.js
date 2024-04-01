/*import React from 'react';
import {useState} from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
*/

//Edit buttons 
// ----------------------------------------------------------------------------------------------------------------------
function handleEditButton(){
    console.log("handleEditButton");

    //get ids for the edit btn and text fields
    var textFields = document.getElementsByClassName("input");
    var editBtn = document.getElementById('editBtn');

    //loop through all fields
    for(var i = 0; i < textFields.length; i++){
        var textField = textFields[i]
    if(textField.hasAttribute('readonly')){
        textField.removeAttribute('readonly');
        editBtn.textContent = "Save";
  } else {
    textField.setAttribute('readonly', true);
    editBtn.textContent = "Edit";
  }
}
};

//same as first function for second set of btns
//could not use same function otherwise clicking one button would change all fields in both tables
function handleEditButton2(){
  console.log("handleEditButton");
  var textFields = document.getElementsByClassName("input2");
  var editBtn = document.getElementById('editBtn2');

  for(var i = 0; i < textFields.length; i++){
      var textField = textFields[i]
  if(textField.hasAttribute('readonly')){
      textField.removeAttribute('readonly');
      editBtn.textContent = "Save";
} else {
  textField.setAttribute('readonly', true);
  editBtn.textContent = "Edit";
}
}
  };

// ----------------------------------------------------------------------------------------------------------------------

// ----------------------------------------------------------------------------------------------------------------------
function addRow() {
  console.log("addRow()");
  // Get the table element by its ID
  var table = document.getElementById('ipRecords');

  // Insert a new row at the end of the table
  var newRow = table.insertRow(-1);

  // Insert cells in the row
  var cell1 = newRow.insertCell(0);
  var cell2 = newRow.insertCell(1);
  var cell3 = newRow.insertCell(2);

  // Add content to the new cells
  cell1.innerHTML = '<input type="text" readonly="readonly" class="input" placeholder="Click Edit to Enter IP Address">';
  cell2.innerHTML = '<input type="text" readonly="readonly" class="input" placeholder="Click Edit to Enter IP Info">';
  cell3.innerHTML = '<input type="text" readonly="readonly" class="input" placeholder="Click Edit to Enter Company">';
}


function addRow2() {
  console.log("addRow2()");
  // Get the table element by its ID
  var table = document.getElementById('ipRecords2');

  // Insert a new row at the end of the table
  var newRow = table.insertRow(-1);

  // Insert cells in the row
  var cell1 = newRow.insertCell(0);
  var cell2 = newRow.insertCell(1);
  var cell3 = newRow.insertCell(2);
  var cell4 = newRow.insertCell(3);

  // Add content to the new cells

  cell1.innerHTML = '<input type="text" readonly="readonly" class="input2" placeholder="Click Edit to Enter Username">';
  cell2.innerHTML = '<input type="text" readonly="readonly" class="input2" placeholder="Click Edit to Enter Password">';
  cell3.innerHTML = '<input type="text" readonly="readonly" class="input2" placeholder="Click Edit to Enter User ID">';
  cell4.innerHTML = '<input type="text" readonly="readonly" class="input2" placeholder="Click Edit to Enter App ID">';
}

// ----------------------------------------------------------------------------------------------------------------------

// ----------------------------------------------------------------------------------------------------------------------
// Function to delete a row from the table
function deleteRow() {
  console.log("deleteRow");

  var ipTable = document.getElementById("ipRecords");

  // Get the number of rows in the table
  var rowCount = ipTable.rows.length;
  
  // Make sure there's more than one row (excluding the header)
  if (rowCount > 1) {
    // Remove the last row
    ipTable.deleteRow(rowCount - 1);
  }
}

function deleteRow2() {
  console.log("deleteRow2");

  var ipTable = document.getElementById("ipRecords2");

  // Get the number of rows in the table
  var rowCount = ipTable.rows.length;
  
  // Make sure there's more than one row (excluding the header)
  if (rowCount > 1) {
    // Remove the last row
    ipTable.deleteRow(rowCount - 1);
  }
}
// ----------------------------------------------------------------------------------------------------------------------
function filterIpTable() {
  // Get the value from a filter input field
  var filterValue = document.getElementById('filterInput').value;
  console.log('Filter Value:', filterValue); // Debugging line
  
  // Get the table and rows
  var table = document.getElementById('ipRecords');
  var tr = table.getElementsByTagName('tr');

  // Loop through all table rows
  for (var i = 1; i < tr.length; i++) {
    var td = tr[i].getElementsByTagName('td')[0];
    if (td) {
      var input = td.querySelector('input');
      var txtValue = input ? input.value : td.textContent || td.innerText;
      console.log('Comparing:', txtValue, 'with', filterValue); // Debugging line
      if (txtValue.includes(filterValue)) {
        tr[i].style.display = '';
      } else {
        tr[i].style.display = 'none';
      }
    }
  }
}





