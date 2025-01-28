import React, { useState } from 'react';
import axios from 'axios';
import CodeEditor from './CodeEditor';

const Compiler = () => {
  const [code, setCode] = useState('');
  const [language, setLanguage] = useState('java');
  const [output, setOutput] = useState('');
  const [useRemote, setUseRemote] = useState(true); // Toggle between local and remote

  // Backend URLs
  const localURL = 'http://localhost:5002';
  const remoteURL = 'https://mindmap-backend-44bg.onrender.com';
  const API_URL = useRemote ? remoteURL : localURL;

  const clientId = 'yourClientId'; // Replace with your client ID
  const clientSecret = 'yourClientSecret'; // Replace with your client secret

  const handleCompile = async () => {
    try {
      // Debugging log
      console.log('Sending Payload:', {
        clientId,
        clientSecret,
        script: code,
        language,
      });

      // Ensure POST request is sent
      const response = await axios.post(`${API_URL}/api/execute`, {
        script: code,
        language: language,
        versionIndex: '0', // Include version index
      });

      console.log('Received Response:', response.data);

      if (response.data.output || response.data.error) {
        setOutput(response.data.output || response.data.error);
      } else {
        setOutput('Unexpected response format from backend.');
      }
    } catch (error) {
      console.error('Error during compilation:', error);
      if (error.response) {
        setOutput(
          `Error from server: ${error.response.data?.message || 'Unknown error'}`
        );
      } else if (error.request) {
        setOutput('No response from server. Check your network or backend.');
      } else {
        setOutput(`Unexpected error: ${error.message}`);
      }
    }
}; 

  return (
    <div>
      <h1>Code Compiler</h1>

      {/* Backend Toggle */}
      <div>
        <label>
          <input
            type="checkbox"
            checked={useRemote}
            onChange={() => setUseRemote(!useRemote)}
          />
          Use Remote Backend ({useRemote ? 'Remote' : 'Local'})
        </label>
      </div>

      {/* Code Editor */}
      <CodeEditor 
        setCode={setCode} 
        code={code} 
        language={language} 
      />

      <div>
        <label>Select Language: </label>
        <select onChange={(e) => setLanguage(e.target.value)} value={language}>
          <option value="java">Java</option>
          <option value="python">Python</option>
          <option value="c">C</option>
          <option value="cpp">C++</option>
        </select>
      </div>

      <div>
        <button onClick={handleCompile}>Compile Code</button>
      </div>

      <div>
        <h2>Output:</h2>
        <pre>{output}</pre>
      </div>
    </div>
  );
};

export default Compiler;
