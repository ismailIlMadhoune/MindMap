import React, { useState } from 'react';
import axios from 'axios';
import CodeEditor from './CodeEditor';

const Compiler = () => {
  const [code, setCode] = useState('');
  const [language, setLanguage] = useState('java');
  const [output, setOutput] = useState('');

  // Use Vite's `import.meta.env` for environment variables
  const API_URL = import.meta.env.VITE_API_URL || 'https://your-render-backend-url.onrender.com';
  const clientId = import.meta.env.VITE_JDOODLE_CLIENT_ID || 'defaultClientId';
  const clientSecret = import.meta.env.VITE_JDOODLE_CLIENT_SECRET || 'defaultClientSecret';
  
  const handleCompile = async () => {
    try {
      const response = await axios.post(`${API_URL}/api/execute`, {
        clientId: clientId,
        clientSecret: clientSecret,
        script: code,
        language: language,
      });

      setOutput(response.data.output || response.data.error);
    } catch (error) {
      setOutput('Error compiling code.');
      console.error(error);
    }
  };

  return (
    <div>
      <h1>Code Compiler</h1>

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
