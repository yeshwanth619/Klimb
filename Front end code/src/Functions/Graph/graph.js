import React from 'react';
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
  ResponsiveContainer,
} from 'recharts';
import { noDataAvailable } from '../../Constants/constants';
import './graph.css';

const Graph = ({ data }) => {






  return (
    <div className="call-graph">
      {data.length > 0 ? (
       
        <ResponsiveContainer width="90%" height={400}>
          <LineChart
            data={data}
            margin={{ top: 20, right: 30, left: 20, bottom: 20 }}
          >
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis dataKey="timestamp" />
            <YAxis />
            <Tooltip labelFormatter={(value) => new Date(value).toLocaleString()} />
            <Legend />
            <Line type="monotone" dataKey="usd" name="usd" stroke="blue" activeDot={{ r: 8 }} />
            <Line type="monotone" dataKey="eur" name="eur" stroke="green" activeDot={{ r: 8 }} />
            <Line type="monotone" dataKey="gbp" name="gbp" stroke="red" activeDot={{ r: 8 }} />
          </LineChart>
        </ResponsiveContainer>
      ) : (

        <div className="no-data-message-container">
          <div className="no-data-message">{noDataAvailable}</div>
        </div>
      )}
    </div>
  );
};

export default Graph;
