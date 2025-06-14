/**
 * 
 */
document.addEventListener("DOMContentLoaded", ()=>{
	const lprodGuSel = document.getElementById('lprodGu');
	const buyerSel = document.getElementById('buyerId');
	
	const guInitVal = lprodGuSel.dataset.initVal;
	const idInitVal = buyerSel.dataset.initVal;
	
	const CPath = document.body.dataset.contextPath;
	axios.get(`${CPath}/ajax/lprod`)
		.then(resp=>{
			const {lprodList} = resp.data;
			if(lprodList){
				const options = lprodList.map(({lprodGu, lprodName}) => 
									`<option value=${lprodGu}>${lprodName}</option>}`)
									.join("\n");
				lprodGuSel.innerHTML += options;
//				if(initVal){				
				lprodGuSel.value = guInitVal ?? "";		
			}
		})
		
		axios.get(`${CPath}/ajax/buyer`)
			.then(resp=>{
				const {buyerList} = resp.data;
				if(buyerList){
					const options = buyerList.map(({buyerId, buyerName, lprodGu}) =>
									`<option class=${lprodGu} value=${buyerId}>${buyerName}</option>`)
									.join('\n');
					buyerSel.innerHTML += options;
					buyerSel.value = idInitVal ?? "";
				}
			})
			
		lprodGuSel.addEventListener('change', (e)=>{
			const selGu = e.target.value; // P101
			buyerSel.querySelectorAll('option[class]').forEach((op)=>{
				if(op.classList.contains(selGu)){
					op.style.display = 'block';
				}else{
					op.style.display = 'none';
				}
			});
		});
	
});