#!/bin/sh 
curl -X POST --header 'Content-Type:application/json' --header 'Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFkbWluQGNhYm9sYWJzLmNvbSIsImV4dHJhZGF0YSI6eyJvcmdfdWlkIjoiZTlkMTMyOTQtYmNlNy00NGU3LTk2MzUtOGU5MDZkYTBjOTE0In0sImlzc3VlZF9hdCI6IjIwMjAtMTItMjFUMTA6Mzg6MTYuNTc0WiIsImV4cGlyZXNfYXQiOiIyMDIwLTEyLTIyVDEwOjM4OjE2LjU3NVoifQ.01rMbHq1y998HEUK_oUr4XN6U9oomLFUdBkhn1oPXWM' --data @/workspace/angular-sdk-example/OutputFile.json http://35.198.226.194:8090/rest/v1/ehrs/1d1d4428-c475-4158-a1df-a69781c81c0c/compositions?auditCommitter=Sumit%20House,%20MD.