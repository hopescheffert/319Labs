/*
  Associate the click functionality with the buton with id "test1"
 */
$(document).ready(function() {
  $('#test1').click(function(){
    createTable(2, 3);
  });
});

/*
  createTable formal arguments: 
      n is the number of rows    m is the number of columns 
  The functional creates a table with the following
  DOM element table structure:
  <table border='2'>
    <tbody>
       <tr>
          <td> ...  </td>
       </tr>
       <tr> ...  </tr>
    </tbody>
  </table>
 */
function createTable(n, m) {
    mytable = $("<table border='2'></table>"); // creates DOM elements
    mytablebody = $('<tbody></tbody>'); 

    for(row = 0; row < n; row++) {
	      curr_row = $('<tr></tr>');

	      for(col = 0; col < m; col++) {
	          curr_cell = $('<td></td>');
	          curr_text = 'Row '+ row + ' Col ' + col;
	          curr_cell.append(curr_text);
	          curr_row.append(curr_cell);
	      }
	      mytablebody.append(curr_row); // appends arg to mytablebody
    }
    mytable.append(mytablebody);
    mytable.insertBefore($('#tablecreate')); // real dom from document!

} // end of function

