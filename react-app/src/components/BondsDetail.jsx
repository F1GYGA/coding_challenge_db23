import * as React from 'react';
import CollapsibleTable from './CollapsableTable';

const BondsDetail = ({info}) => {
    return <CollapsibleTable rows={info}/>
}
// <Table>
//     <thead>
//         <tr>
//             <th scope='col'> ISIN </th>
//             <th scope='col'> CUSIP </th>
//             <th scope='col'> Issuer </th>
//             <th scope='col'> </th>
//         </tr>
//     </thead>
//     <tbody>{props.info.map((bond)=>(
//         <tr key={bond.isin}>
//             <td>{bond.isin}</td>
//             <td>{bond.cusip}</td>
//             <td>{bond.issuer_name}</td>
//             <td><Button onClick={DisplayDetails}>Show More Details</Button></td>
//         </tr>
//     ))}

//     </tbody>
// </Table>

export default BondsDetail;