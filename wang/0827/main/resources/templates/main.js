/**
 *
 */


function newgame(){
	//初期化
	init();

}

var board = new Array();

function init(){
	for(var i =0; i<4; i++){
		board[i] = new Array();
		for(var j = 0; j<4; j++){
			//すべてのグリッドを0に初期化
			board[i][j]=0;
			console.log(board[i][j]);
			var gridCell = $("#grid-cell-"+i+"-"+j);
			//TOPからの距離を計算
			gridCell.css({'top': getPosTop(i)+ 'px'});
			console.log(getPosTop(i));
			//LEFTからの距離を計算
			gridCell.css({'left': getPosLeft(j) +'px'});


		}
	}


function getPosTop(i){
	return (20 + i*120);
}

function getPosLeft(j){
	return (20 + j*120);
}




}