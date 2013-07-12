# Endpoint Index

* [GET /](endpoints/misc.md#verifying-that-metadactyl-clj-is-running)
* [POST /add-analysis-to-group](endpoints/app-metadata/categorization.md#adding-analyses-to-analysis-groups)
* [GET /analysis-data-objects/{analysis-id}](endpoints/app-metadata/listing.md#listing-data-objects-in-an-analysis)
* [GET /analysis-details/{analysis-id}](endpoints/app-metadata/information.md#getting-analysis-details)
* [GET /analysis-rerun-info/{job-id}](endpoints/app-execution.md#obtaining-information-to-rerun-a-job)
* [GET /app-rerun-info/{job-id}](endpoints/app-execution.md#obtaining-information-to-rerun-a-job-in-the-new-format)
* [POST /arg-preview](endpoints/app-metadata/updated-admin.md#previewing-command-line-arguments)
* [POST /can-export-analysis](endpoints/app-metadata/validation.md#determining-if-an-analysis-can-be-exported)
* [POST /categorize-analyses](endpoints/app-metadata/categorization.md#categorizing-analyses)
* [POST /delete-categories](endpoints/app-metadata/categorization.md#deleting-categories)
* [POST /delete-workflow](endpoints/app-metadata/admin.md#logically-deleting-an-analysis)
* [POST /export-deployed-components](endpoints/app-metadata/admin.md#exporting-selected-deployed-components)
* [GET /export-template/{template-id}](endpoints/app-metadata/admin.md#exporting-a-template)
* [GET /export-workflow/{analysis-id}](endpoints/app-metadata/admin.md#exporting-an-analysis)
* [POST /force-update-workflow](endpoints/app-metadata/admin.md#forcing-an-analysis-to-be-updated)
* [GET /get-all-analysis-ids](endpoints/app-metadata/listing.md#listing-analysis-identifiers)
* [GET /get-analysis-categories/{category-set}](endpoints/app-metadata/categorization.md#listing-analysis-categorizations)
* [GET /get-analysis/{analysis-id}](endpoints/app-metadata/information.md#getting-analyses-in-the-json-format-required-by-the-de)
* [GET /get-app-description/{analysis-id}](endpoints/app-metadata/information.md#getting-an-app-description)
* [GET /get-property-values/{job-id}](endpoints/app-execution.md#obtaining-property-values-for-a-previously-executed-job)
* [GET /get-workflow-elements/{element-type}](endpoints/app-metadata/listing.md#listing-workflow-elements)
* [POST /import-template](endpoints/app-metadata/admin.md#importing-a-template)
* [POST /import-tools](endpoints/app-metadata/admin.md#importing-tools)
* [POST /import-workflow](endpoints/app-metadata/admin.md#importing-an-analysis)
* [GET /list-analysis/{analysis-id}](endpoints/app-metadata/listing.md#listing-individual-analyses)
* [POST /permanently-delete-workflow](endpoints/app-metadata/admin.md#permanently-deleting-an-analysis)
* [POST /preview-template](endpoints/app-metadata/admin.md#previewing-templates)
* [POST /preview-workflow](endpoints/app-metadata/admin.md#previewing-analyses)
* [GET /public-app-groups](endpoints/app-metadata/listing.md#listing-analysis-groups)
* [GET /search-deployed-components/{search-term}](endpoints/app-metadata/listing.md#search-deployed-components)
* [GET /secured/app-groups](endpoints/app-metadata/listing.md#listing-analysis-groups)
* [GET /secured/app/{app-id}](endpoints/app-metadata/updated-admin.md#obtaining-app-information-for-job-submission)
* [GET /secured/bootstrap](endpoints/misc.md#initializing-a-users-workspace)
* [GET /secured/collaborators](endpoints/collaborators.md#listing-collaborators)
* [POST /secured/collaborators](endpoints/collaborators.md#adding-collaborators)
* [GET /secured/copy-template/{analysis-id}](endpoints/app-metadata/editing.md#making-a-copy-of-an-analysis-available-for-editing-in-tito)
* [GET /secured/copy-workflow/{analysis-id}](endpoints/app-metadata/editing.md#making-a-copy-of-a-pipeline-available-for-editing)
* [POST /secured/delete-rating](endpoints/app-metadata/rating.md#deleting-analysis-ratings)
* [GET /secured/edit-app/{app-id}](endpoints/app-metadata/updated-admin.md#obtaining-an-app-representation-for-editing)
* [GET /secured/edit-template/{analysis-id}](endpoints/app-metadata/editing.md#making-an-analysis-available-for-editing-in-tito)
* [GET /secured/edit-workflow/{analysis-id}](endpoints/app-metadata/editing.md#making-a-pipeline-available-for-editing)
* [GET /secured/get-analyses-in-group/{group-id}](endpoints/app-metadata/listing.md#listing-analyses-in-an-analysis-group)
* [GET /secured/get-components-in-analysis/{analysis-id}](endpoints/app-metadata/listing.md#listing-deployed-components-in-an-analysis)
* [POST /secured/make-analysis-public](endpoints/app-metadata/editing.md#submitting-an-analysis-for-public-use)
* [POST /secured/rate-analysis](endpoints/app-metadata/rating.md#rating-analyses)
* [GET /secured/reference-genomes](endpoints/reference-genomes.md#exporting-reference-genomes)
* [PUT /secured/reference-genomes](endpoints/reference-genomes.md#importing-reference-genomes)
* [POST /secured/remove-collaborators](endpoints/collaborators.md#removing-collaborators)
* [GET /secured/search-analyses](endpoints/app-metadata/listing.md#searching-for-analyses)
* [GET /secured/template/{analysis-id}](endpoints/app-metadata/information.md#getting-analyses-in-the-json-format-required-by-the-de)
* [PUT /secured/tool-request](endpoints/app-metadata/tool-requests.md#requesting-tool-installation)
* [PUT /secured/update-app](endpoints/app-metadata/updated-admin.md#updating-or-importing-a-single-step-app)
* [POST /secured/update-favorites](endpoints/app-metadata/admin.md#updating-the-favorite-analyses-list)
* [PUT /secured/workspaces/{workspace-id}/executions/delete](endpoints/app-execution.md#deleting-jobs)
* [GET /secured/workspaces/{workspace-id}/executions/list](endpoints/app-execution.md#listing-jobs)
* [POST /secured/workspaces/{workspace-id}/executions/list](endpoints/app-execution.md#getting-status-information-for-selected-jobs)
* [PUT /secured/workspaces/{workspace-id}/newexperiment](endpoints/app-execution.md#submitting-a-job-for-execution)
* [POST /tool-request](endpoints/app-metadata/tool-requests.md#updating-the-status-of-a-tool-request)
* [GET /tool-request/{uuid}](endpoints/app-metadata/tool-requests.md#obtaining-tool-request-details)
* [GET /tool-requests](endpoints/app-metadata/tool-requests.md#listing-tool-requests)
* [POST /update-analysis](endpoints/app-metadata/admin.md#updating-top-level-analysis-information)
* [POST /update-app-labels](endpoints/app-metadata/admin.md#updating-template-labels)
* [POST /update-template](endpoints/app-metadata/admin.md#updating-an-existing-template)
* [POST /update-workflow](endpoints/app-metadata/admin.md#updating-an-analysis)
* [GET /validate-analysis-for-pipelines/{analysis-id}](endpoints/app-metadata/validation.md#validating-analyses-for-pipelines)