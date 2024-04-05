import React from 'react';
import {Card, Table} from 'react-bootstrap';
import { Link } from 'react-router-dom';
import'./IPRecords.css';

 
function IPRecords(props) {


  return (
 

    <div class="content">
    
    <div class="crud-container">
        <form class="crud-Form">
            <button type="button" id="addRecordBtn" class="add-button">Add New Record</button>
            <button type="button" id="exportExcelBtn" class="edit-button">Export to Excel</button>
        </form>
    </div>
    <div class="table-container">
        <table id="ipRecords">
            <thead>
                <tr>
                    <th>IP Address</th>
                    <th>Application ID</th>
                    <th>Server</th>
                    <th>Port</th>
                    <th>Date Modified</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
 
 

  );
}

export default IPRecords;