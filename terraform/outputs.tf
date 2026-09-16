output "public_ip" {
  description = "Elastic IP of the service"
  value       = aws_eip.app.public_ip
}

output "service_url" {
  description = "Base URL of the live service (after DNS A record points at public_ip)"
  value       = "https://${var.domain_name}"
}

output "api_key_ssm_parameter" {
  description = "Retrieve the API key with: aws ssm get-parameter --name <this> --with-decryption --query Parameter.Value --output text"
  value       = aws_ssm_parameter.api_key.name
}

output "ecr_repository_url" {
  description = "ECR repository to push the image to"
  value       = aws_ecr_repository.app.repository_url
}

output "artifacts_bucket" {
  description = "S3 bucket holding normalized JSON / full-text artifacts"
  value       = aws_s3_bucket.artifacts.bucket
}

output "registry_table" {
  description = "DynamoDB processing-record registry table"
  value       = aws_dynamodb_table.registry.name
}
