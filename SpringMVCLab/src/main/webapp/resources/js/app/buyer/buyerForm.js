/**
 * 
 */
document.addEventListener("DOMContentLoaded", ()=>{
	const lprodGuSel = document.getElementById('lprodGu');
	const initVal = lprodGuSel.dataset.initVal;
	const CPath = document.body.dataset.contextPath;
	axios.get(`${CPath}/ajax/lprod`)
		.then(resp=>{
			const lprodList = resp.data;
			if(lprodList){
				const options = lprodList.map(({lprodGu, lprodName}) => 
									`<option value=${lprodGu}>${lprodName}</option>}`)
									.join("\n");
				lprodGuSel.innerHTML += options;
//				if(initVal){				
				lprodGuSel.value = initVal ?? "";
					
			}
			
		})
});